package JunHo

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val record: Array<String> = arrayOf(
            "Enter uid1234 Muzi", "Enter uid4567 Prodo",
            "Leave uid1234", "Enter uid1234 Prodo",
            "Change uid4567 Ryan")
    val chat:Pro_OpenChat = Pro_OpenChat()
    println(chat.solution(record))
}
class Pro_OpenChat {
    val ENTER: String = "Enter"
    val LEAVE: String = "Leave"
    fun solution(record: Array<String>): Array<String> {
        val command: HashMap<String, String> = hashMapOf(ENTER to "님이 들어왔습니다.", LEAVE to "님이 나갔습니다.")
        val userInfo: HashMap<String, String> = HashMap()
        val msgList: ArrayList<Message> = ArrayList()

        for (msg in record) {
            val token = msg.split(" ").toTypedArray()
            val com = token[0]
            val uid = token[1]

            if (token.size == 3) {
                userInfo[uid] = token[2]
            }
            if (com == ENTER || com == LEAVE) {
                msgList.add(Message(uid, command[com] ?: throw KotlinNullPointerException()))
            }
        }

        val result: Array<String> = Array(msgList.size) { "" }
        for (i in result.indices) {
            result[i] = userInfo[msgList[i].uid] + msgList[i].msg
        }
        return result
    }

    data class Message(val uid: String, val msg: String)
}