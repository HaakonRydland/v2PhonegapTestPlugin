package cordova.plugin.v3simpleplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class v3SimplePlugin extends CordovaPlugin {
    // Main  method for interacting with native code
    @Override
    public boolean execute(String action, final JSONArray args, final CallbackContext callbackContext)
        throws JSONException {
        if (action.equals("printData")) {
            PrintData();
            callbackContext.success("okay");
            return true;
        }

        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            coolMethod(message, callbackContext);
            return true;
        }

        if (action.equals("toastMessage")) {
        	String message = args.getString(0);
            toastMessage(message);
            callbackContext.success("okay");
            return true;
        }

        return false;
    }

    public void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    public void toastMessage(String messageToSend) {
        cordova.getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast myMessage = Toast.makeText(cordova.getActivity().getWindow().getContext(), messageToSend, Toast.LENGTH_LONG);
                myMessage.show();
            }
        });
    }

    public void PrintData() {
        cordova.getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                Toast myMessage = Toast.makeText(cordova.getActivity().getWindow().getContext(), "This message is from PrintData()", Toast.LENGTH_LONG);
                myMessage.show();
            }
        });
    }
}
