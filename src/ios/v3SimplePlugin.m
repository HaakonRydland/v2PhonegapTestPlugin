/********* v3SimplePlugin.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "UIAlertController.h"

@interface v3SimplePlugin : CDVPlugin {
  // Member variables go here.
}

- (void)coolMethod:(CDVInvokedUrlCommand*)command;
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

- (void)toastMessage:(CDVInvokedUrlCommand*)command
{
NSString *message = 'iOS message from PhoneGap plugin v3SimplePlugin';    

    UIAlertController *alert = [UIAlertController alertControllerWithTitle:nil message:message  preferredStyle:UIAlertControllerStyleActionSheet];

    [self presentViewController:alert animated:YES completion:nil];

    int duration = 3;

    dispatch_after(dispatch_time(DISPATCH_TIME_NOW, duration * NSEC_PER_SEC), dispatch_get_main_queue(), ^{

        [alert dismissViewControllerAnimated:YES completion:nil];

    });
}

@end

 