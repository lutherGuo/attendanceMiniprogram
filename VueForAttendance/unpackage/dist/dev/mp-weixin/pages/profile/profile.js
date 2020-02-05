(global["webpackJsonp"] = global["webpackJsonp"] || []).push([["pages/profile/profile"],{

/***/ 160:
/*!****************************************************************************!*\
  !*** D:/岭师帮小程序uniapp/指纹考勤小程序/main.js?{"page":"pages%2Fprofile%2Fprofile"} ***!
  \****************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(createPage) {__webpack_require__(/*! uni-pages */ 4);__webpack_require__(/*! @dcloudio/uni-stat */ 5);

var _vue = _interopRequireDefault(__webpack_require__(/*! vue */ 2));
var _profile = _interopRequireDefault(__webpack_require__(/*! ./pages/profile/profile.vue */ 161));function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };}
createPage(_profile.default);
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ 1)["createPage"]))

/***/ }),

/***/ 161:
/*!*********************************************************!*\
  !*** D:/岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue ***!
  \*********************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./profile.vue?vue&type=template&id=43bb4f19& */ 162);
/* harmony import */ var _profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./profile.vue?vue&type=script&lang=js& */ 164);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__[key]; }) }(__WEBPACK_IMPORT_KEY__));
/* harmony import */ var _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/vue-loader/lib/runtime/componentNormalizer.js */ 14);





/* normalize component */

var component = Object(_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_runtime_componentNormalizer_js__WEBPACK_IMPORTED_MODULE_2__["default"])(
  _profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_1__["default"],
  _profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__["render"],
  _profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"],
  false,
  null,
  null,
  null
  
)

/* hot reload */
if (false) { var api; }
component.options.__file = "岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue"
/* harmony default export */ __webpack_exports__["default"] = (component.exports);

/***/ }),

/***/ 162:
/*!****************************************************************************************!*\
  !*** D:/岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue?vue&type=template&id=43bb4f19& ***!
  \****************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_hbuilderx_packages_webpack_uni_nvue_loader_lib_templateLoader_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-hbuilderx/packages/webpack-uni-nvue-loader/lib/templateLoader.js??vue-loader-options!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--17-0!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/vue-loader/lib??vue-loader-options!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-custom-block-loader??ref--0-1!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./profile.vue?vue&type=template&id=43bb4f19& */ 163);
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "render", function() { return _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_hbuilderx_packages_webpack_uni_nvue_loader_lib_templateLoader_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__["render"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_hbuilderx_packages_webpack_uni_nvue_loader_lib_templateLoader_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_17_0_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_template_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_template_id_43bb4f19___WEBPACK_IMPORTED_MODULE_0__["staticRenderFns"]; });



/***/ }),

/***/ 163:
/*!***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/@dcloudio/vue-cli-plugin-hbuilderx/packages/webpack-uni-nvue-loader/lib/templateLoader.js??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--17-0!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/template.js!./node_modules/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-custom-block-loader??ref--0-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!D:/岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue?vue&type=template&id=43bb4f19& ***!
  \***************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! exports provided: render, staticRenderFns */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "render", function() { return render; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "staticRenderFns", function() { return staticRenderFns; });
var render = function() {
  var _vm = this
  var _h = _vm.$createElement
  var _c = _vm._self._c || _h
}
var staticRenderFns = []
render._withStripped = true



/***/ }),

/***/ 164:
/*!**********************************************************************************!*\
  !*** D:/岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue?vue&type=script&lang=js& ***!
  \**********************************************************************************/
/*! no static exports found */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! -!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/babel-loader/lib!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/vue-loader/lib??vue-loader-options!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-custom-block-loader??ref--0-1!../../../../HBuilderX/HBuilderX/plugins/uniapp-cli/node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!./profile.vue?vue&type=script&lang=js& */ 165);
/* harmony import */ var _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__);
/* harmony reexport (unknown) */ for(var __WEBPACK_IMPORT_KEY__ in _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__) if(__WEBPACK_IMPORT_KEY__ !== 'default') (function(key) { __webpack_require__.d(__webpack_exports__, key, function() { return _HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0__[key]; }) }(__WEBPACK_IMPORT_KEY__));
 /* harmony default export */ __webpack_exports__["default"] = (_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_babel_loader_lib_index_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_preprocess_loader_index_js_ref_12_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_script_js_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_vue_loader_lib_index_js_vue_loader_options_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_vue_cli_plugin_uni_packages_webpack_custom_block_loader_index_js_ref_0_1_HBuilderX_HBuilderX_plugins_uniapp_cli_node_modules_dcloudio_webpack_uni_mp_loader_lib_style_js_profile_vue_vue_type_script_lang_js___WEBPACK_IMPORTED_MODULE_0___default.a); 

/***/ }),

/***/ 165:
/*!**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/babel-loader/lib!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-preprocess-loader??ref--12-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/script.js!./node_modules/vue-loader/lib??vue-loader-options!./node_modules/@dcloudio/vue-cli-plugin-uni/packages/webpack-custom-block-loader??ref--0-1!./node_modules/@dcloudio/webpack-uni-mp-loader/lib/style.js!D:/岭师帮小程序uniapp/指纹考勤小程序/pages/profile/profile.vue?vue&type=script&lang=js& ***!
  \**********************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

"use strict";
/* WEBPACK VAR INJECTION */(function(uni) {Object.defineProperty(exports, "__esModule", { value: true });exports.default = void 0;










































































































































































































var _notify = _interopRequireDefault(__webpack_require__(/*! ../../wxcomponents/vant/notify/notify.js */ 166));
var _toast = _interopRequireDefault(__webpack_require__(/*! ../../wxcomponents/vant/toast/toast */ 168));function _interopRequireDefault(obj) {return obj && obj.__esModule ? obj : { default: obj };} //
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
var clickCircle = function clickCircle() {return __webpack_require__.e(/*! import() | components/zwy/clickCircle */ "components/zwy/clickCircle").then(__webpack_require__.bind(null, /*! ../../components/zwy/clickCircle.vue */ 417));};var _default = { components: { clickCircle: clickCircle }, data: function data() {return { show: true, modalName: null, realNameInfo: null, userInfo: {}, wxUser: {}, switchMsg: "" };}, onLoad: function onLoad() {console.log("onLoad()");}, onShow: function onShow() {this.userInfo = uni.getStorageSync("userInfo");console.log("onShow()");if (!this.userInfo) {this.warnNotify();} else {// 每次都要更新的
      this.getUidAndSuper(); // this.getRealName()
    }}, methods: { SwitchSendMsg: function SwitchSendMsg(e) {this.switchMsg = e.detail.value;this.userInfo.switchMsg = this.switchMsg;console.log("that.userInfo.switchMsg=" + this.userInfo.switchMsg);if (this.userInfo.switchMsg == true) {}}, wakeUpMsg: function wakeUpMsg() {if (this.userInfo.switchMsg == true) {wx.requestSubscribeMessage({ tmplIds: ['jxm2u-gMXptrgJBsHOThe9-1L4Vw2dghG7J05FLEEKk'], success: function success(res) {console.log(res);}, fail: function fail(err) {console.log(err);} });}}, conClick: function conClick(e) {this.$refs.clickCircle.conClick(e);}, warnNotify: function warnNotify() {(0, _notify.default)({ text: "未登录", duration: 1000, backgroundColor: 'blue', position: "bottom" });}, successNotify: function successNotify(title) {(0, _notify.default)({ backgroundColor: 'green', text: title, position: "bottom" });}, onTowast: function onTowast(mes) {(0, _toast.default)("adad");}, showModal: function showModal(e) {this.modalName = e.currentTarget.dataset.target;}, hideModal: function hideModal(e) {this.modalName = null;}, exitLogin: function exitLogin() {var that = this;uni.showModal({ title: "确定要退出吗", success: function success(res) {if (res.confirm) {that.userInfo = null;uni.setStorageSync("userInfo", null);console.log(that.userInfo);}} });}, getUidAndSuper: function getUidAndSuper() {console.log("that.userInfo.uId=" + this.userInfo);var that = this;uni.request({ url: "http://47.100.59.153:8080/attendance/wxUser/login", data: { "openId": that.userInfo.openid, "avatarUrl": that.userInfo.avatarUrl, "nickName": that.userInfo.nickName }, // header:{
        // 	"Content-Type":'applicantion/json'
        // },
        success: function success(res) {var title = "";var icon = "success";console.log(res.data.success);that.userInfo.uId = res.data.wxUserInfo.uId;that.userInfo.sSuper = res.data.wxUserInfo.sSuper;uni.request({ url: "http://47.100.59.153:8080/attendance/realName/getRealName", data: { "uId": that.userInfo.uId }, success: function success(res) {console.log(res.data);that.realNameInfo = res.data.realNameInfo;that.userInfo.realNameInfo = res.data.realNameInfo;uni.setStorageSync("userInfo", that.userInfo);that.userInfo = uni.getStorageSync("userInfo");} });if (res.data.success != false) {if (res.data.success == null) {if (res.data.wxUserInfo.sSuper == 0) {title = "欢迎回来超管";} else {title = "欢迎回来";}} else if (res.data.success == true) {title = "欢迎您加入岭师考勤系统";}} else {title = "失败", icon = "none";}that.successNotify(title);console.log(res);} });}, getRealName: function getRealName() {var that = this;console.log("that.userInfo.uId=" + this.userInfo);uni.request({ url: "http://47.100.59.153:8080/attendance/realName/getRealName", data: { "uId": that.userInfo.uId }, success: function success(res) {console.log(res.data);that.realNameInfo = res.data.realNameInfo;that.userInfo.realNameInfo = res.data.realNameInfo;uni.setStorageSync("userInfo", that.userInfo);that.userInfo = uni.getStorageSync("userInfo");} });}, getUserinfo: function getUserinfo(res) {var that = this;if (!res.detail.iv) {uni.showToast({ title: "求求你授权吧" });return false;}console.log(res);that.userInfo = res.detail.userInfo; // 调用云函数获取openid
      wx.cloud.callFunction({ name: 'login', data: {}, success: function success(res) {console.log('[云函数] [login] user openid: ', res.result.openid);that.userInfo.openid = res.result.openid;that.switchMsg = true;that.userInfo.switchMsg = true;that.getUidAndSuper(); // console.log("that.userInfo.sSper:::"+that.userInfo.sSper)
          // that.getRealName()
          // uni.setStorageSync("userInfo", that.userInfo)
        }, fail: function fail(err) {
          console.error('[云函数] [login] 调用失败', err);
        } });


    },



    realNameSubmit: function realNameSubmit(e) {
      var that = this;
      console.log(e.detail.value);
      var sId = e.detail.value.sId;
      var pwd = e.detail.value.pwd;
      var email = e.detail.value.email;


      if (!sId || !pwd || !email) {
        // this.onTowast("请填写完整")
        uni.showToast({
          title: "请填写完整",
          icon: "none" });

        return false;
      }
      uni.request({
        url: "http://47.100.59.153:8080/attendance/realName/tieRealName",
        data: {
          "uId": that.userInfo.uId,
          "sId": e.detail.value.sId,
          "password": e.detail.value.pwd,
          "email": e.detail.value.email },

        success: function success(res) {
          var title = "";

          console.log(res.data.success);
          var msg = res.data.success;
          if (msg == "tied") {
            title = "此学号已绑定";
          } else if (msg == "noExist") {
            title = "账号不存在或密码错误";
          } else if (msg == true) {
            title = "绑定成功";
            that.hideModal();
            that.getRealName();
          } else {
            title = "绑定失败";
          }
          uni.showToast({
            title: title,
            icon: "none" });

          that.successNotify(title);
        } });


    },

    sendMsg: function sendMsg(e) {
      wx.requestSubscribeMessage({
        tmplIds: [
        'il9K_JqyWPEIKbIHaSMHMvRM3BYAMt_UC6gCVERpXjU'],

        success: function success(res) {
          console.log(res);
        },
        fail: function fail(err) {
          console.log(err);
        } });

    },

    getMsg: function getMsg() {
      wx.cloud.callFunction({
        name: 'sendMsg',
        data: {},

        success: function success(res) {
          console.log(res);
          wx.showToast({
            title: '发送成功!' });


        },
        fail: function fail(err) {
          console.log(err);
          wx.showToast({
            title: '发送失败!' });

        } });

    } } };exports.default = _default;
/* WEBPACK VAR INJECTION */}.call(this, __webpack_require__(/*! ./node_modules/@dcloudio/uni-mp-weixin/dist/index.js */ 1)["default"]))

/***/ })

},[[160,"common/runtime","common/vendor"]]]);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/profile/profile.js.map