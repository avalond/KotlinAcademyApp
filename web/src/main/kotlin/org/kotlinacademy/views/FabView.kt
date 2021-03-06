package org.kotlinacademy.views

import kotlinx.html.UL
import kotlinx.html.js.onClickFunction
import org.kotlinacademy.common.sendEvent
import react.RBuilder
import react.ReactElement
import react.dom.*

fun RBuilder.fabView(): ReactElement? = div(classes = "fab") {
    span(classes = "fab-action-button") {
        i(classes = "fab-action-button__icon") { }
    }
    ul(classes = "fab-buttons") {
        fabOption("#/feedback/null", "Add feedback", Image.TALK)
        fabOption("https://blog.kotlin-academy.com/write-for-kotlin-academy-abebd70937ce", "Submit an article", Image.ARTICLE)
        fabOption("#/submit-info", "Submit news", Image.PLUS)
        fabOption("#/submit-puzzler", "Submit puzzler", Image.PLUS)
    }
}

private fun RDOMBuilder<UL>.fabOption(link: String, text: String, image: Image) {
    li(classes = "fab-buttons__item") {
        a(href = link, classes = "fab-buttons__link") {
            setProp("data-tooltip", text)
            i(classes = "icon-material ${image.clz}") { }
            attrs {
                onClickFunction = {
                    sendEvent("FAB", text, text)
                }
            }
        }
    }
}

private enum class Image(val clz: String) {
    TALK("icon-material_talk"),
    PLUS("icon-material_plus"),
    ARTICLE("icon-material_article_plus"),
}