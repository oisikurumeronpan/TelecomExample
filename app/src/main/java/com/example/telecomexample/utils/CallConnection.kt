package com.example.telecomexample.utils

import android.content.Context
import android.os.Bundle
import android.telecom.CallAudioState
import android.telecom.Connection
import android.telecom.DisconnectCause
import android.util.Log

class CallConnection(context: Context): Connection() {
    val TAG = "CallConnection"

    override fun onCallAudioStateChanged(state: CallAudioState?) {
        super.onCallAudioStateChanged(state)
    }

    override fun onStateChanged(state: Int) {
        super.onStateChanged(state)
    }

    override fun onDisconnect() {
        super.onDisconnect()
    }

    override fun onHold() {
        super.onHold()
    }

    override fun onAnswer() {
        super.onAnswer()
    }

    override fun onAnswer(videoState: Int) {
        super.onAnswer(videoState)
    }

    override fun onCallEvent(event: String?, extras: Bundle?) {
        super.onCallEvent(event, extras)
    }

    override fun onShowIncomingCallUi() {
        super.onShowIncomingCallUi()
    }

    override fun onReject() {
        super.onReject()
    }

    override fun onReject(rejectReason: Int) {
        super.onReject(rejectReason)
    }

    override fun onReject(replyMessage: String?) {
        super.onReject(replyMessage)
    }

    override fun onAbort() {
        super.onAbort()
    }


}