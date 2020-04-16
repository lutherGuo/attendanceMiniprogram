<template>
<uni-shadow-root class="vant-tabbar-item-index"><view :class="(utils.bem('tabbar-item', { active }))+' custom-class'" :style="active && color ? 'color: ' + color : ''" @click="onClick">
  <view :class="utils.bem('tabbar-item__icon', { dot })">
    <van-icon v-if="icon" :name="icon" customStyle="display: block"></van-icon>
    <block v-else>
      <slot v-if="active" name="icon-active"></slot>
      <slot v-else name="icon"></slot>
    </block>
    <van-info v-if="info !== null" :info="info" custom-style="margin-top: 2px"></van-info>
  </view>
  <view class="van-tabbar-item__text">
    <slot></slot>
  </view>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>
import VanIcon from '../icon/index.vue'
import VanInfo from '../info/index.vue'
global['__wxVueOptions'] = {components:{'van-icon': VanIcon,'van-info': VanInfo}}

global['__wxRoute'] = 'vant/tabbar-item/index'
import { VantComponent } from '../common/component';
VantComponent({
    props: {
        info: null,
        icon: String,
        dot: Boolean
    },
    relation: {
        name: 'tabbar',
        type: 'ancestor',
        linked(target) {
            this.parent = target;
        }
    },
    data: {
        active: false
    },
    methods: {
        onClick() {
            if (this.parent) {
                this.parent.onChange(this);
            }
            this.$emit('click');
        },
        setActive({ active, color }) {
            if (this.data.active !== active) {
                return this.set({ active, color });
            }
            return Promise.resolve();
        }
    }
});
export default global['__wxComponents']['vant/tabbar-item/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.vant-tabbar-item-index{-webkit-flex:1;flex:1}.van-tabbar-item{color:#7d7e80;height:100%;display:-webkit-flex;display:flex;line-height:1;font-size:12px;-webkit-align-items:center;align-items:center;-webkit-flex-direction:column;flex-direction:column;-webkit-justify-content:center;justify-content:center}.van-tabbar-item__icon{font-size:18px;margin-bottom:5px;position:relative}.van-tabbar-item__icon--dot:after{top:0;right:-8px;width:8px;height:8px;content:" ";position:absolute;border-radius:100%;background-color:#f44}.van-tabbar-item__icon image{width:30px;height:18px;display:block}.van-tabbar-item--active{color:#1989fa}
</style>