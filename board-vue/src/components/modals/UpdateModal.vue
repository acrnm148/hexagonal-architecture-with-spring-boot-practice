<template>
  <div class="modal fade" id="updateModal">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">글 수정하기</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <label for="titleUpdate" class="form-label">제목</label>
            <input type="text" class="form-control" id="titleUpdate" v-model="title" />
          </div>
          <div class="mb-3">
            <label for="contentUpdate" class="form-label">내용</label>
            <!-- CKEditor update -->
            <div id="divEditorUpdate"></div>
          </div>
          <div class="mb-3">
            <!-- <div class="form-check">
              <input
                class="form-check-input"
                type="checkbox"
                value=""
                id="chkFileUploadUpdate"
                v-model="attachFile"
              />
              <label class="form-check-label" for="chkFileUploadUpdate">파일 변경</label>
            </div> -->
          </div>
          <!-- <div v-show="attachFile" class="mb-3" id="imgFileUploadUpdateWrapper">
            <input @change="changeFile" type="file" id="inputFileUploadUpdate" multiple />
            <div id="imgFileUploadUpdateThumbnail" class="thunbnail-wrapper">
              <img v-for="(file, index) in fileList" :key="index" v-bind:src="file" alt="" />
            </div>
          </div> -->
          <button @click="boardUpdate" type="button" class="btn btn-sm btn-success float-end">
            수정
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import VueAlertify from "vue-alertify";
Vue.use(CKEditor).use(VueAlertify);
import http from "@/common/axios.js";

export default {
  props: ["board"],
  data() {
    return {
      boardId: "",
      title: "",
      contents: "",
      CKEditor: "",
      // attachFile: false,
      // fileList: [],
    };
  },
  methods: {
    // changeFile(fileEvent) {
    //   // 파일 미리보기
    //   // 첨부할 파일목록
    //   this.fileList = [];

    //   const fileArray = Array.from(fileEvent.target.files);
    //   fileArray.forEach((file) => {
    //     this.fileList.push(URL.createObjectURL(file));
    //   });
    // },
    async boardUpdate() {
      let text = this.CKEditor.getData();
      text = text.replace(/<br\/>/gi, "\n");
      text = text.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/gi, "");
      text = text.replace(/(<([^>]+)>)/gi, "");
      text = text.replace(/&nbsp;/gi, "");

      let formData = new FormData();
      formData.append("boardId", this.boardId);
      formData.append("title", this.title);
      formData.append("contents", text);
      formData.append("author", "강수나");

      // file 각각을 formData 에 추가
      // let attachFiles = document.querySelector("#inputFileUploadUpdate").files;
      // if (attachFiles.length > 0) {
      //   const fileArray = Array.from(attachFiles);
      //   fileArray.forEach((file) => formData.append("file", file));
      // }

      // multipart/form-data
      let options = {
        //headers: {"Content-Type": "multipart/form-data"},
        headers: {"Content-Type": "application/json"},
      };

      try {
        let response = await http.put("/boards", formData, options); //await http.post("/boards/" + this.boardId, formData, options);
        let {data} = response;

        console.log(data);

        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          // 등록 성공
          this.$alertify.success("글이 수정되었습니다.");
          this.closeModal();
        }
      } catch (error) {
        this.$alertify.error("글 수정 과정에서 오류가 발생했습니다.");
      }
    },
    closeModal() {
      this.$emit("call-parent-update");
    },
  },
  async mounted() {
    try {
      this.CKEditor = await ClassicEditor.create(document.querySelector("#divEditorUpdate"));
    } catch (error) {
      console.error(error);
    }
  },
  watch: {
    // props board 를 watch
    board: function () {
      console.log("watch!!");
      this.boardId = this.board.boardId; // this.board <- props
      this.title = this.board.title;
      this.CKEditor.setData(this.board.contents);

      // 첨부파일 관련 초기화
      // this.fileList = [];
      // this.attachFile = false;
      // document.querySelector("#inputFileUploadUpdate").value = "";
    },
  },
};
</script>

<style scoped>
/* deep selector */
.modal >>> .ck-editor__editable {
  height: 200px;
}

.modal >>> .thunbnail-wrapper {
  margin-top: 5px;
}

.modal >>> .thunbnail-wrapper img {
  width: 100px !important;
  margin-right: 5px;
  max-width: 100%;
}
</style>
