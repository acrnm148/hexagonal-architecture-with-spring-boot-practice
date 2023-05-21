<template>
  <div class="container">
    <h4 class="text-center mt-3">👩‍🌾<strong>BOARD</strong>👩‍🌾</h4>

    <div class="input-group mb-3 mt-3">
      <input
        type="text"
        class="form-control"
        v-model="searchWord"
        @keydown.enter="boardList"
        placeholder="Search"
      />
      <button class="btn btn-success" type="button" @click="boardList">Search</button>
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">제목</th>
          <th scope="col">내용</th>
          <th scope="col">작성자</th>
          <th scope="col">작성일자</th>
          <!-- <th scope="col">조회수</th> -->
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(row, index) in this.list"
          :key="index"
          @click="boardDetail(row.boardId)"
          style="cursor: pointer"
        >
          <td>{{ row.boardId }}</td>
          <td>{{ row.title }}</td>
          <td>{{ row.contents }}</td>
          <td>{{ row.author }}</td>
          <td>{{ row.regDttm }}</td>
          <!-- <td>{{ row.regDttm | makeDateStr(".") }}</td> -->
          <!-- <td>{{ row.readCount }}</td> -->
        </tr>
      </tbody>
    </table>

    <!-- PaginationUI Component 4개 props 필요 -->
    <pagination-u-i
      v-bind:listRowCount="listRowCount"
      v-bind:pageLinkCount="pageLinkCount"
      v-bind:currentPageIndex="currentPageIndex"
      v-bind:totalListItemCount="totalListItemCount"
      v-on:call-parent-move-page="movePage"
    ></pagination-u-i>

    <button class="btn btn-success" type="button" @click="showInsertModal">글쓰기</button>
    <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    <detail-modal
      v-bind:board="board"
      v-on:call-parent-change-to-update="changeToUpdate"
      v-on:call-parent-change-to-delete="changeToDelete"
    ></detail-modal>
    <update-modal v-bind:board="board" v-on:call-parent-update="closeAfterUpdate"></update-modal>
  </div>
</template>

<script>
import http from "@/common/axios.js"; //axios객체
import util from "@/common/util.js";
import PaginationUI from "@/components/PaginationUI.vue";
import InsertModal from "@/components/modals/InsertModal.vue"; //vue 컴포넌트
import DetailModal from "@/components/modals/DetailModal.vue"; //vue 컴포넌트
import UpdateModal from "@/components/modals/UpdateModal.vue";
import {Modal} from "bootstrap"; //vue 컴포넌트에서 bootstrap modal 을 사용하기 위함.

export default {
  components: {
    PaginationUI,
    InsertModal,
    DetailModal,
    UpdateModal,
  },
  data() {
    return {
      limit: 10,
      offset: 0,
      searchWord: "",
      list: [],
      //row

      totalListItemCount: 0,
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      // modal
      insertModal: null, //bootstrap Modal 객체를 할당(ui component를 전달)
      detailModal: null,
      updateModal: null,

      //detail
      board: {
        boardId: 0,
        title: "",
        contents: "",
        author: "",
        regDttm: "",
      },
    };
  },
  methods: {
    async boardDetail(boardId) {
      //row
      // 백엔드 요청 - 결과
      // DetailModal <- 결과 : data항목에 board 객체를 추가하고 props로 DetailModal에 넘겨준다. 백엔드 요청 결과를 data의 board를 변경하면 자동 반영
      // DetailModal show
      try {
        let response = await http.get(`/boards/${boardId}`);
        let {data} = response;
        console.log(data);

        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          let boardNew = {
            ...data.data, //나머지는 여기서 받음 - 3dot operator rest
          };

          //현재 board 교체
          this.board = boardNew;

          this.detailModal.show();
        }
      } catch (error) {
        console.error(error);
        this.$alertify.error("서버에 문제가 생겼습니다.");
      }
    },
    async boardList() {
      let params = {
        limit: this.limit,
        offset: this.offset,
        searchWord: this.searchWord,
      };

      try {
        // axios가 json으로 parameter를 보내는 방법 : 객체를 전달
        let response = await http.get("/boards", {params});
        let {data} = response;

        // interceptor session check fail
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.list = data.data;
          console.log(this.list);
          this.totalListItemCount = data.count;
        }
      } catch (error) {
        console.error(error);
        this.$alertify.error("서버에 문제가 생겼습니다.");
      }
    },
    changeToUpdate() {
      this.detailModal.hide();
      this.updateModal.show();
    },
    movePage(pageIndex) {
      this.offset = (pageIndex - 1) * this.listRowCount;
      this.currentPageIndex = pageIndex;
      this.boardList();
    },
    showInsertModal() {
      this.insertModal.show();
    },
    closeAfterInsert() {
      this.insertModal.hide();
      this.boardList();
    },
    closeAfterUpdate() {
      this.updateModal.hide();
      this.boardList();
    },
    changeToDelete() {
      this.detailModal.hide();
      var $this = this;
      this.$alertify.confirm(
        "이 글을 삭제하시겠습니까?",
        function () {
          //this.boardDelete(); //이렇게 쓰는 this는 컴포넌트를 가리키는게 아님.
          $this.boardDelete();
        },
        function () {
          console.log("cancel");
        }
      );
    },
    async boardDelete() {
      try {
        let response = await http.delete("/boards/" + this.board.boardId);
        let {data} = response;
        if (data.result == "login") {
          this.$router.push("/login");
        } else {
          this.$alertify.success("글이 삭제되었습니다.");
          this.boardList();
        }
      } catch (error) {
        console.error(error);
      }
    },
  },
  created() {
    this.boardList();
  },
  mounted() {
    //모달 객체를 생성해서 data의 변수에 할당
    this.insertModal = new Modal(document.querySelector("#insertModal"));
    this.detailModal = new Modal(document.querySelector("#detailModal"));
    this.updateModal = new Modal(document.querySelector("#updateModal"));
  },
  filters: {
    makeDateStr(date, type) {
      console.log(date.year);
      return util.makeDateStr(date.year, date.month, date.day, type); //import한 util을 이용해서 filter
    },
  },
  watch: {
    board() {
      this.boardList();
    },
  },
};
</script>

<style></style>
