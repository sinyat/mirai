package net.mamoe.mirai.network.protocol.tim.packet.event

import android.graphics.Bitmap
import kotlinx.io.core.Input
import net.mamoe.mirai.contact.Contact
import net.mamoe.mirai.message.*
import net.mamoe.mirai.utils.InternalAPI
import java.io.File
import java.io.InputStream
import java.net.URL

/**
 * 平台相关扩展
 */
@UseExperimental(InternalAPI::class)
actual sealed class MessagePacket<TSubject : Contact> : MessagePacketBase<TSubject>() {
    suspend inline fun uploadImage(image: Bitmap): Image = subject.uploadImage(image)
    suspend inline fun uploadImage(image: URL): Image = subject.uploadImage(image)
    suspend inline fun uploadImage(image: Input): Image = subject.uploadImage(image)
    suspend inline fun uploadImage(image: InputStream): Image = subject.uploadImage(image)
    suspend inline fun uploadImage(image: File): Image = subject.uploadImage(image)

    suspend inline fun sendImage(image: Bitmap) = subject.sendImage(image)
    suspend inline fun sendImage(image: URL) = subject.sendImage(image)
    suspend inline fun sendImage(image: Input) = subject.sendImage(image)
    suspend inline fun sendImage(image: InputStream) = subject.sendImage(image)
    suspend inline fun sendImage(image: File) = subject.sendImage(image)

    suspend inline fun Bitmap.upload(): Image = upload(subject)
    suspend inline fun URL.uploadAsImage(): Image = uploadAsImage(subject)
    suspend inline fun Input.uploadAsImage(): Image = uploadAsImage(subject)
    suspend inline fun InputStream.uploadAsImage(): Image = uploadAsImage(subject)
    suspend inline fun File.uploadAsImage(): Image = uploadAsImage(subject)

    suspend inline fun Bitmap.send() = sendTo(subject)
    suspend inline fun URL.sendAsImage() = sendAsImageTo(subject)
    suspend inline fun Input.sendAsImage() = sendAsImageTo(subject)
    suspend inline fun InputStream.sendAsImage() = sendAsImageTo(subject)
    suspend inline fun File.sendAsImage() = sendAsImageTo(subject)
}