<template>
<uni-shadow-root class="vant-cell-group-index"><view v-if="title" class="van-cell-group__title">
  {{ title }}
</view>
<view :class="'custom-class van-cell-group '+(border ? 'van-hairline--top-bottom' : '')">
  <slot></slot>
</view></uni-shadow-root>
</template>

<script>

global['__wxRoute'] = 'vant/cell-group/index'
import { VantComponent } from '../common/component';
VantComponent({
    props: {
        title: String,
        border: {
            type: Boolean,
            value: true
        }
    }
});
export default global['__wxComponents']['vant/cell-group/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-cell-group__title{font-size:14px;padding:15px 15px 5px;color:#999;line-height:16px}
</style>