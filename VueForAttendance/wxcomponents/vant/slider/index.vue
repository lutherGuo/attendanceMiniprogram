<template>
<uni-shadow-root class="vant-slider-index"><view :class="'custom-class '+(utils.bem('slider', { disabled }))" :style="inactiveColor ? 'background:' + inactiveColor : ''" @click="onClick">
  <view class="van-slider__bar" :style="(barStyle)+'; '+(activeColor ? 'background:' + activeColor : '')">
    <view class="van-slider__button-wrapper" @touchstart="onTouchStart" @touchmove.stop.prevent="onTouchMove" @touchend="onTouchEnd" @touchcancel="onTouchEnd">
      <slot v-if="useButtonSlot" name="button"></slot>
      <view v-else class="van-slider__button"></view>
    </view>
  </view>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>

global['__wxRoute'] = 'vant/slider/index'
import { VantComponent } from '../common/component';
import { touch } from '../mixins/touch';
VantComponent({
    mixins: [touch],
    props: {
        disabled: Boolean,
        useButtonSlot: Boolean,
        activeColor: String,
        inactiveColor: String,
        max: {
            type: Number,
            value: 100
        },
        min: {
            type: Number,
            value: 0
        },
        step: {
            type: Number,
            value: 1
        },
        value: {
            type: Number,
            value: 0
        },
        barHeight: {
            type: String,
            value: '2px'
        }
    },
    watch: {
        value(value) {
            this.updateValue(value, false);
        }
    },
    created() {
        this.updateValue(this.data.value);
    },
    methods: {
        onTouchStart(event) {
            if (this.data.disabled)
                return;
            this.touchStart(event);
            this.startValue = this.format(this.data.value);
        },
        onTouchMove(event) {
            if (this.data.disabled)
                return;
            this.touchMove(event);
            this.getRect('.van-slider').then((rect) => {
                const diff = this.deltaX / rect.width * 100;
                this.updateValue(this.startValue + diff, false, true);
            });
        },
        onTouchEnd() {
            if (this.data.disabled)
                return;
            this.updateValue(this.data.value, true);
        },
        onClick(event) {
            if (this.data.disabled)
                return;
            this.getRect('.van-slider').then((rect) => {
                const value = (event.detail.x - rect.left) / rect.width * 100;
                this.updateValue(value, true);
            });
        },
        updateValue(value, end, drag) {
            value = this.format(value);
            this.set({
                value,
                barStyle: `width: ${value}%; height: ${this.data.barHeight};`
            });
            if (drag) {
                this.$emit('drag', { value });
            }
            if (end) {
                this.$emit('change', value);
            }
        },
        format(value) {
            const { max, min, step } = this.data;
            return Math.round(Math.max(min, Math.min(value, max)) / step) * step;
        }
    }
});
export default global['__wxComponents']['vant/slider/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-slider{position:relative;border-radius:999px;background-color:#e5e5e5}.van-slider__bar{position:relative;border-radius:inherit;background-color:#1989fa}.van-slider__button{width:20px;height:20px;border-radius:50%;background-color:#fff;box-shadow:0 1px 2px rgba(0,0,0,.5)}.van-slider__button-wrapper{position:absolute;top:50%;right:0;-webkit-transform:translate3d(50%,-50%,0);transform:translate3d(50%,-50%,0)}.van-slider__button-wrapper:after{content:"";position:absolute;width:200%;height:200%;top:-50%;left:-50%}.van-slider--disabled{opacity:.3}
</style>