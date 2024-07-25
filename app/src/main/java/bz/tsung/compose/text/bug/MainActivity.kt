package bz.tsung.compose.text.bug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import bz.tsung.compose.text.bug.ui.theme.ComposeTextBugTheme

private const val INLINE_TXT = "- [ ]"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTextBugTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Greeting(
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight())
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val text = buildAnnotatedString {
        for (i in 0 until 10) {
            appendInlineContent(INLINE_TXT)
            append("We cannot solve our problems with the same thinking we used when we created them.")
        }
    }

    val inlineContent = mutableMapOf<String, InlineTextContent>()
    inlineContent[INLINE_TXT] = InlineTextContent(
        Placeholder(14.sp, 14.sp, PlaceholderVerticalAlign.Center)
    ) {
        Image(
            imageVector = Icons.Default.AddCircle,
            contentDescription = null
        )
    }
    Text(
        text = text,
        inlineContent = inlineContent,
        maxLines = 4,
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
    )
}