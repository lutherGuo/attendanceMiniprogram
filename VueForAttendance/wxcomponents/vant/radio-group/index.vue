<template>
<uni-shadow-root class="vant-radio-group-index"><slot></slot></uni-shadow-root>
</template>

<script>
import VanIcon from '../icon/index.vue'
global['__wxVueOptions'] = {components:{'van-icon': VanIcon}}

global['__wxRoute'] = 'vant/radio-group/index'
import { VantComponent } from '../common/component';
VantComponent({
    field: true,
    relation: {
        name: 'radio',
        type: 'descendant',
        linked(target) {
            const { value, disabled } = this.data;
            target.set({
                value: value,
                disabled: disabled || target.data.disabled
            });
        }
    },
    props: {
        value: null,
        disabled: Boolean
    },
    watch: {
        value(value) {
            const children = this.getRelationNodes('../radio/index');
            children.forEach(child => {
                child.set({ value });
            });
        },
        disabled(disabled) {
            const children = this.getRelationNodes('../radio/index');
            children.forEach(child => {
                child.set({ disabled: disabled || child.data.disabled });
            });
        }
    }
});
export default global['__wxComponents']['vant/radio-group/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';
</style>