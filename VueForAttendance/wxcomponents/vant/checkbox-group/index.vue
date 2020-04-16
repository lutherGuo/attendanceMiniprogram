<template>
<uni-shadow-root class="vant-checkbox-group-index"><slot></slot></uni-shadow-root>
</template>

<script>
import VanIcon from '../icon/index.vue'
global['__wxVueOptions'] = {components:{'van-icon': VanIcon}}

global['__wxRoute'] = 'vant/checkbox-group/index'
import { VantComponent } from '../common/component';
VantComponent({
    field: true,
    relation: {
        name: 'checkbox',
        type: 'descendant',
        linked(target) {
            const { value, disabled } = this.data;
            target.set({
                value: value.indexOf(target.data.name) !== -1,
                disabled: disabled || target.data.disabled
            });
        }
    },
    props: {
        max: Number,
        value: Array,
        disabled: Boolean
    },
    watch: {
        value(value) {
            const children = this.getRelationNodes('../checkbox/index');
            children.forEach(child => {
                child.set({ value: value.indexOf(child.data.name) !== -1 });
            });
        },
        disabled(disabled) {
            const children = this.getRelationNodes('../checkbox/index');
            children.forEach(child => {
                child.set({ disabled: disabled || child.data.disabled });
            });
        }
    }
});
export default global['__wxComponents']['vant/checkbox-group/index']
</script>
<style platform="mp-weixin">
@import '../common/index.css';
</style>