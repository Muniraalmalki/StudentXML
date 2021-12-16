package com.example.studentxml

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class XMLParser {

    private val students = ArrayList<Students>()
    private var text: String? = null

    private var studentName = ""
    private var studentId = 0
    private var studentGrade = 0f

    fun parse(inputStream:InputStream): ArrayList<Students> {
        try {
            val  factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream,null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT){
                val tagName = parser.name
                when(eventType){
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when{
                        tagName.equals("id", ignoreCase = true)-> {studentId = text.toString().toInt()}
                        tagName.equals("name", ignoreCase = true)-> {studentName = text.toString()}
                        tagName.equals("grade", ignoreCase = true)-> {studentGrade = text!!.toFloat()}
                        tagName.equals("student", ignoreCase = true)-> {students.add(Students(studentId, studentName,studentGrade))}
                        else ->{}
                    }
                }
                eventType = parser.next()
            }

        }catch (e:XmlPullParserException){
            e.printStackTrace()
        }catch (e:IOException){
            e.printStackTrace()
        }

      return students
    }
}