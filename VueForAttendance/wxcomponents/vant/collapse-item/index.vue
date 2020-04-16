<template>
<uni-shadow-root class="vant-collapse-item-index"><view :class="'van-collapse-item custom-class '+(index !== 0 ? 'van-hairline--top' : '')">
  <van-cell :title="title" title-class="title-class" :icon="icon" :is-link="isLink" :value="value" :label="label" :border="border && expanded" :class="utils.bem('collapse-item__title', { disabled, expanded })" right-icon-class="van-cell__right-icon" custom-class="van-cell" hover-class="van-cell--hover" @click="onClick">
    <slot name="title" slot="title"></slot>
    <slot name="icon" slot="icon"></slot>
    <slot name="value"></slot>
    <slot name="right-icon" slot="right-icon"></slot>
  </van-cell>
  <view class="van-collapse-item__wrapper" :style="'height: '+(contentHeight)+';'" :animation="animationData" @transitionend="onTransitionEnd">
    <view class="van-collapse-item__content content-class">
      <slot></slot>
    </view>
  </view>
</view></uni-shadow-root>
</template>
<wxs src="../wxs/utils.wxs" module="utils"></wxs>
<script>
import VanCell from '../cell/index.vue'
global['__wxVueOptions'] = {components:{'van-cell': VanCell}}

global['__wxRoute'] = 'vant/collapse-item/index'
import { VantComponent } from '../common/component';
VantComponent({
    classes: ['title-class', 'content-class'],
    relation: {
        name: 'collapse',
        type: 'ancestor',
        linked(parent) {
            this.parent = parent;
        }
    },
    props: {
        name: null,
        title: null,
        value: null,
        icon: String,
        label: String,
        disabled: Boolean,
        border: {
            type: Boolean,
            value: true
        },
        isLink: {
            type: Boolean,
            value: true
        }
    },
    data: {
        contentHeight: 0,
        expanded: false
    },
    beforeCreate() {
        this.animation = wx.createAnimation({
            duration: 300,
            timingFunction: 'ease-in-out'
        });
    },
    methods: {
        updateExpanded() {
            if (!this.parent) {
                return null;
            }
            const { value, accordion, items } = this.parent.data;
            const { name } = this.data;
            const index = items.indexOf(this);
            const currentName = name == null ? index : name;
            const expanded = accordion
                ? value === currentName
                : value.some(name => name === currentName);
            if (expanded !== this.data.expanded) {
                this.updateStyle(expanded);
            }
            this.set({ index, expanded });
        },
        updateStyle(expanded) {
            this.getRect('.van-collapse-item__content').then(res => {
                const animationData = this.animation
                    .height(expanded ? res.height : 0)
                    .step()
                    .export();
                if (expanded) {
                    this.set({ animationData });
                }
                else {
                    this.set({
                        contentHeight: res.height + 'px'
                    }, () => {
                        setTimeout(() => {
                            this.set({ animationData });
                        }, 20);
                    });
                }
            });
        },
        onClick() {
            if (this.data.disabled) {
                return;
            }
            const { name, expanded } = this.data;
            const index = this.parent.data.items.indexOf(this);
            const currentName = name == null ? index : name;
            this.parent.switch(currentName, !expanded);
        },
        onTransitionEnd() {
            if (this.data.expanded) {
                this.set({
                    contentHeight: 'auto'
                });
            }
        }
    }
});
export default global['__wxComponents']['vant/collapse-item/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';.van-collapse-item__title .van-cell__right-icon{-webkit-transform:rotate(90deg);transform:rotate(90deg);transition:.3s}.van-collapse-item__title--expanded .van-cell__right-icon{-webkit-transform:rotate(-90deg);transform:rotate(-90deg)}.van-collapse-item__title--disabled .van-cell,.van-collapse-item__title--disabled .van-cell__right-icon{color:#c9c9c9!important}.van-collapse-item__title--disabled .van-cell--hover{background-color:#fff!important}.van-collapse-item__wrapper{overflow:hidden}.van-collapse-item__content{padding:15px;font-size:13px;line-height:1.5;color:#999;background-color:#fff}
</style>