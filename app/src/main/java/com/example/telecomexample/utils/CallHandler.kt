package com.example.telecomexample.utils

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.telecom.PhoneAccount
import android.telecom.PhoneAccountHandle
import android.telecom.TelecomManager
import android.util.Log
import android.widget.Toast

class CallHandler(context: Context) {
    var callManagerContext = context;
    var telecomManager: TelecomManager =
        context.getSystemService(Context.TELECOM_SERVICE) as TelecomManager
    lateinit var phoneAccountHandle: PhoneAccountHandle

    fun init() {
        val componentName = ComponentName(callManagerContext, CallConnectionService::class.java)
        phoneAccountHandle = PhoneAccountHandle(componentName, "Calling")
        val phoneAccount = PhoneAccount.builder(phoneAccountHandle, "Calling")
            .setCapabilities(PhoneAccount.CAPABILITY_CALL_PROVIDER).build()

        telecomManager.registerPhoneAccount(phoneAccount)
    }

    fun startIncomingCall() {
        if (callManagerContext.checkSelfPermission(Manifest.permission.MANAGE_OWN_CALLS) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            val extras = Bundle()
            extras.putParcelable(TelecomManager.EXTRA_PHONE_ACCOUNT_HANDLE, phoneAccountHandle)
            extras.putBoolean(TelecomManager.EXTRA_START_CALL_WITH_SPEAKERPHONE, true)
            val isCallPermitted = telecomManager.isIncomingCallPermitted(phoneAccountHandle)
            try {
                Log.e("startIncomingCall: ", extras.toString() + "\n" + isCallPermitted)
                telecomManager.addNewIncomingCall(phoneAccountHandle, extras)
            } catch (e: SecurityException) {
                val intent = Intent()
                intent.action = TelecomManager.ACTION_CHANGE_PHONE_ACCOUNTS
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                callManagerContext.startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(callManagerContext, "Error occured:" + e.message, Toast.LENGTH_LONG)
                    .show()
            }
        } else {
            Log.e("startIncomingCall: ", "Permission not granted")
        }
    }
}