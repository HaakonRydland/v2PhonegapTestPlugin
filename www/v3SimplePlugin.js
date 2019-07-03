var exec = require('cordova/exec');

function v3SimplePlugin() {}

v3SimplePlugin.prototype.PluginName = "v3SimplePlugin";

v3SimplePlugin.prototype.pInvoke = function(method, data, callbackOK, callbackError) {
    if (data == null || data === undefined) {
        data = [];
    } else if (!Array.isArray(data)) {
        data = [data];
    }
    exec(callbackOK, callbackError, this.PluginName, method, data);
};

v3SimplePlugin.prototype.printData = function(data, callbackOK, callbackError) {
    this.pInvoke("printData", data, callbackOK, callbackError);
};

v3SimplePlugin.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.v3SimplePlugin = new v3SimplePlugin();
    return window.plugins.v3SimplePlugin;
 };

 cordova.addConstructor(v3SimplePlugin.install);

// standardgreier
exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'v3SimplePlugin', 'coolMethod', [arg0]);
};
