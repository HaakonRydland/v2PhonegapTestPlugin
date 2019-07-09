/********* v3SimplePlugin.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface v3SimplePlugin : CDVPlugin {
  // Member variables go here.
}

- (void)coolMethod:(CDVInvokedUrlCommand*)command;
- (NSString)toastMessage:(CDVInvokedUrlCommand*)command;
@end

@implementation v3SimplePlugin

- (void)coolMethod:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];

    if (echo != nil && [echo length] > 0) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (NSString)toastMessage:(CDVInvokedUrlCommand*)command
{
    NSString *message = 'iOS message from PhoneGap plugin v3SimplePlugin';    
    return message;
}

@end

 