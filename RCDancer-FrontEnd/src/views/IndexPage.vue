<template>
  <div class="index-page">
    <v-content>
      <v-container>
        <v-layout column>
          <!-- logo and signature -->
          <v-flex class="py-2" row justify-center>
            <div class="logo-banner">
              <img class="logo-icon hidden-md-and-down" src="@/assets/img/logo.png" alt="logo">
              <span class="logo-signature display-4 font-weight-black">
                <span class="primary--text">Dancer</span>
              </span>
            </div>
          </v-flex>
          <!-- file Upload  -->
          <v-flex 
            class="py-2 px-4 file-upload-container"
            justify-center
            align-center>
            <record-upload xs12></record-upload>
            <v-btn xs12 large outline color="primary" @click="$router.push('train')">
              开始新练习
              <v-icon>chevron_right</v-icon>
            </v-btn>
            <!-- <div class="hint-word font-weight-black">
              <v-icon color="primary">info</v-icon>
              <div class="px-2">点击上传想要练习的舞蹈视频或录像吧</div>  
            </div> -->
          </v-flex>
          <!-- history gallery -->
          <v-flex class="py-2 history-gallery-container">
            <history-gallery></history-gallery>
          </v-flex>
        </v-layout>
      </v-container>
    </v-content>
  </div>
</template>

<script>
import recordUpload from "@/components/custom_related/DC_UploadSelector";
import historyGallery from "@/components/HistoryGallery";
export default {
  data () {
    return {

    }
  },
  components: {
    recordUpload,
    historyGallery
  }
};
</script>

<style lang="stylus" scoped>
.logo-icon {
  height: 7.5rem;
  width: auto;
  vertical-align: bottom;
}
.index-page {
  .file-upload-container {
    position: relative;
    min-height: 10rem;
    .record-upload {
      height: 4rem;
      flex: 0 0 50%;
    }
    .hint-word {
      position: absolute;
      bottom: 0;
      display: flex;
      align-items: center;
    }
  }
}
</style>
