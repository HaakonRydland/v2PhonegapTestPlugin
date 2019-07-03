package cordova.plugin.v3simpleplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class v3SimplePlugin extends CordovaPlugin {

//    @Override
//    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
//        if (action.equals("coolMethod")) {
//            String message = args.getString(0);
//            this.coolMethod(message, callbackContext);
//            return true;
//        }
//        return false;
//    }

    @Override
    public boolean execute(String action, final CordovaArgs args, final CallbackContext callbackContext)
        throws JSONException {
        if (action.equals("printData")) {
            PrintData();
            callbackContext.success("okay");
            return true;
        }

        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    public void PrintData() {
        cordova.GetActivity().runOnUiThread(new Runnable {
            @Override
                    public void run() {
                Toast myMessage = Toast.makeText(cordova.getActivity().getWindow().getContext(), "This message is from v3SimplePlugin", Toast.LENGTH_LONG);
                myMessage.show();
            }
        });
    }

}
