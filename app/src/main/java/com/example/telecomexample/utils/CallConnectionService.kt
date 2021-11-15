package com.example.telecomexample.utils

import android.os.Build
import android.telecom.*
import android.util.Log

class CallConnectionService: ConnectionService() {

    companion object {
        var conn : CallConnection? = null
    }

    override fun onCreateIncomingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        conn = CallConnection(applicationContext)
        conn?.setCallerDisplayName("hoge", TelecomManager.PRESENTATION_ALLOWED)
        conn?.setInitializing()
        conn?.setActive()

        return conn!!
    }

    override fun onCreateIncomingConnectionFailed(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ) {
        super.onCreateIncomingConnectionFailed(connectionManagerPhoneAccount, request)
        Log.e("onCreateIncomingFailed:",request.toString())
    }

    override fun onCreateOutgoingConnection(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ): Connection {
        return super.onCreateOutgoingConnection(connectionManagerPhoneAccount, request)
    }

    override fun onCreateOutgoingConnectionFailed(
        connectionManagerPhoneAccount: PhoneAccountHandle?,
        request: ConnectionRequest?
    ) {
        super.onCreateOutgoingConnectionFailed(connectionManagerPhoneAccount, request)
    }
}