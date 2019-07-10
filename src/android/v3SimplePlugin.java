package cordova.plugin.v3simpleplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.widget.Toast;

public class v3SimplePlugin extends CordovaPlugin {
    // Bridge from JavaScript: calls the corresponding native method based on action-parameter
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
        if (action.equals("echo")) {
            String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;
        }
        if (action.equals("stringFromNativeCode")) {
            this.stringFromNativeCode(callbackContext);
            return true;
        }
        return false;
    }

    // Methods that can be called from JavaScript
    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument");
        }
    }

    public void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    public void stringFromNativeCode(CallbackContext callbackContext) {
        String gotContact = "Android message from PhoneGap plugin v3SimplePlugin";
        callbackContext.success(gotContact);
    }

    /* Most methods run on WebCore thread. Can override to UiThread to interact with user interface
    or use ExecutorServices (cordova.getThreadPool().execute(new Runnable() {...))) to avoid blocking WebCore thread
    for long operations */
    public void toastMessage(final String messageToSend) {
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
