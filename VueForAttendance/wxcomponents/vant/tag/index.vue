<template>
<uni-shadow-root class="vant-tag-index"><view :class="'custom-class '+(utils.bem('tag', [size, { mark, plain, round }]))+' '+(plain ? 'van-hairline--surround' : '')" :style="style">
  <slot></slot>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>

global['__wxRoute'] = 'vant/tag/index'
import { VantComponent } from '../common/component';
import { RED, BLUE, GREEN } from '../common/color';
const DEFAULT_COLOR = '#999';
const COLOR_MAP = {
    danger: RED,
    primary: BLUE,
    success: GREEN
};
VantComponent({
    props: {
        size: String,
        type: String,
        mark: Boolean,
        color: String,
        plain: Boolean,
        round: Boolean,
        textColor: String
    },
    computed: {
        style() {
            const color = this.data.color || COLOR_MAP[this.data.type] || DEFAULT_COLOR;
            const key = this.data.plain ? 'color' : 'background-color';
            const style = { [key]: color };
            if (this.data.textColor) {
                style.color = this.data.textColor;
            }
            return Object.keys(style).map(key => `${key}: ${style[key]}`).join(';');
        }
    }
});
export default global['__wxComponents']['vant/tag/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-tag{color:#fff;font-size:10px;padding:.2em .5em;line-height:normal;border-radius:.2em;display:inline-block}.van-tag:after{border-color:currentColor;border-radius:.4em}.van-tag--mark{padding-right:.6em;border-radius:0 .8em .8em 0}.van-tag--mark:after{border-radius:0 1.6em 1.6em 0}.van-tag--round{border-radius:.8em}.van-tag--round:after{border-radius:1.6em}.van-tag--medium{font-size:12px}.van-tag--large{font-size:14px}
</style>