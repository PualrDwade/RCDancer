<template>
  <div class="record-upload">
    <input class="upload-item" id="upload" type="file">
    <label for="upload" class="upload-container">
      <span class="red-dot dot"></span>
      <span class="green-dot dot"></span>
      <span class="yellow-dot dot"></span>
      <span class="upload-icon">
        <!-- <v-icon small color="white">cloud_upload</v-icon> -->
            <v-progress-circular
      indeterminate
      size="17"
      width= 3
      color="white"
    ></v-progress-circular>
      </span>
    </label>
  </div>
</template>
<script>
export default {
  name: "record-upload",
  data() {
    return {};
  }
};
</script>

<style lang="stylus" scoped>
@keyframes uploadAnimate {
  from {
    transform: translateY(0);
  }

  to {
    transform: translateY(-40%);
  }
}
@keyframes twinkleAnimate {
  from {
    background-color: yellow;
  }

  to {
    background-color: $primaryColor;
  }
}
.upload-item {
  display: none;
}

.record-upload {
  flex-grow: 1;
  padding: 4px 16px;
  height: 35px;

  .upload-container {
    display: flex;
    position: relative;
    height: 100%;
    background: #404040;
    transition: all 0.2s ease;
    align-items: center;
    cursor: pointer;
    box-shadow: 0px -5px 5px rgba(0, 0, 0, 0.2);

    // border: 2px solid $primaryColor
    &::after {
      // content: 'UPLOAD VIDEO';
      content: '';
      position: absolute;
      width: 50%;
      height: 10px;
      left: 25%;
      border: 1px solid #ccc;
      border-width: 2px 1px;
    }

    &:hover {
      background: #303030;

      .upload-icon {
        animation: uploadAnimate 500ms infinite alternate;
      }
    }

    .dot {
      display: inline-block;
      width: 10px;
      height: 10px;
      border-radius: 50%;
    }

    .red-dot {
      background-color: red;
      margin-left: 10px;
    }

    .green-dot {
      background-color: green;
      margin-left: 5px;
    }

    .yellow-dot {
      background-color: yellow;
      margin-left: 5px;
      animation: twinkleAnimate 500ms infinite alternate;
    }

    .upload-icon {
      padding-right: 15px;
      flex-grow: 1;
      text-align: right;
    }
  }
}
</style>
