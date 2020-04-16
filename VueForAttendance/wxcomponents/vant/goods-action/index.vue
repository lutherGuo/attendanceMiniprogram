<template>
<uni-shadow-root class="vant-goods-action-index"><view :class="'custom-class '+(utils.bem('goods-action', { safe: isIPhoneX && safeAreaInsetBottom }))">
  <slot></slot>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>

global['__wxRoute'] = 'vant/goods-action/index'
import { VantComponent } from '../common/component';
import { safeArea } from '../mixins/safe-area';
VantComponent({
    mixins: [safeArea()]
});
export default global['__wxComponents']['vant/goods-action/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-goods-action{position:fixed;right:0;bottom:0;left:0;display:-webkit-flex;display:flex;background-color:#fff}.van-goods-action--safe{padding-bottom:34px}
</style>