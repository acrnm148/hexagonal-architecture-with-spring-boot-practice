<template>
  <!-- Modal Detail-->
  <div
    class="modal fade"
    id="detailModal"
    tabindex="-1"
    aria-labelledby="exampleModalLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">글 상세</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <table class="table table-hover">
            <tbody>
              <tr>
                <td>글 번호</td>
                <td>{{ board.boardId }}</td>
              </tr>
              <tr>
                <td>제목</td>
                <td>{{ board.title }}</td>
              </tr>
              <tr>
                <td>내용</td>
                <td v-html="board.contents"></td>
                <!-- {{board.boardId}} 로 쓰면 html 태그 다나옴 (CKEditor의 내용은 html 태그로 구성)-->
              </tr>
              <tr>
                <td>작성자</td>
                <td>{{ board.author }}</td>
              </tr>
              <tr>
                <td>작성일시</td>
                <td>{{ board.regDttm }}</td>
                <!-- <td>{{ board.regDate }} {{ board.regTime }}</td> -->
              </tr>
              <!-- <tr>
                <td>조회수</td>
                <td>{{ board.readCount }}</td>
              </tr> -->

              <!-- 첨부파일
              <tr>
                <td colspan="2">첨부파일</td>
              </tr>
              <tr v-if="board.fileList.length > 0">
                <td colspan="2">
                  <div v-for="(file, index) in board.fileList" :key="index">
                    <span class="fileName">{{ file.fileName }}</span>
                    &nbsp;&nbsp;
                    <a
                      type="button"
                      class="btn btn-outline btn-success btn-xs"
                      v-bind:href="file.fileUrl"
                      v-bind:download="file.fileName"
                      >내려받기</a
                    >
                  </div>
                </td>
              </tr> -->
            </tbody>
          </table>
        </div>

        <div class="modal-footer">
          <button type="button" @click="changeToUpdate" class="btn btn-sm btn-success">수정</button>
          <button
            id="btnBoardDeleteConfirm"
            type="button"
            @click="changeToDelete"
            class="btn btn-sm btn-warning"
          >
            삭제
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["board"],
  methods: {
    changeToUpdate() {
      this.$emit("call-parent-change-to-update");
    },
    changeToDelete() {
      this.$emit("call-parent-change-to-delete");
    },
  },
};
</script>

<style></style>
