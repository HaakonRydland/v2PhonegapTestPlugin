var exec = require('cordova/exec');

function v3SimplePlugin() {}

v3SimplePlugin.prototype.PluginName = "v3SimplePlugin";

// Kjører alle metoder den får tilsendt
// method: metode som skal kjøres i native kode
// data: input som gis videre til metoden i native kode
v3SimplePlugin.prototype.pInvoke = function(method, data, callbackOK, callbackError) {
    console.log('JS Interface: inside pInvoke()');
    if (data == null || data === undefined) {
        data = [];
    } else if (!Array.isArray(data)) {
        data = [data];
    }
    exec(callbackOK, callbackError, this.PluginName, method, data);
};

// Genererer en toast message i native kode
v3SimplePlugin.prototype.printData = function(data, callbackOK, callbackError) {
    console.log('JS Interface: inside printData()');
    this.pInvoke("printData", data, callbackOK, callbackError);
};

// Genererer en toast message i native kode
v3SimplePlugin.prototype.toastMessage = function(data, callbackOK, callbackError) {
    console.log('JS Interface: inside toastMessage()');
    this.pInvoke("toastMessage", data, callbackOK, callbackError);
};

v3SimplePlugin.prototype.coolMethod = function(data, callbackOK, callbackError) {
    console.log('JS Interface: inside coolMethod()');
    this.pInvoke("coolMethod", data, callbackOK, callbackError);
};

v3SimplePlugin.prototype.echo = function(str, callback, callbackError) {
    console.log('JS Interface: inside echo()');
    this.pInvoke("echo", [str], callback, callbackError);
};

v3SimplePlugin.install = function() {
    console.log('JS Interface: inside install()');
    if (!window.plugins) {
        window.plugins = {};
    }

    window.plugins.v3SimplePlugin = new v3SimplePlugin();
    return window.plugins.v3SimplePlugin;
 };

 cordova.addConstructor(v3SimplePlugin.install);

// // standardgreier
// exports.coolMethod = function (arg0, success, error) {
//     exec(success, error, 'v3SimplePlugin', 'coolMethod', [arg0]);
// };
