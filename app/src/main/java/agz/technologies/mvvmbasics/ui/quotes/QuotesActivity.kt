package agz.technologies.mvvmbasics.ui.quotes

import agz.technologies.mvvmbasics.R
import agz.technologies.mvvmbasics.data.Quote
import agz.technologies.mvvmbasics.utilities.InjectorUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            var textView : TextView = findViewById(R.id.textView_quotes)
            textView.text = stringBuilder.toString()
        })

        val button : Button = findViewById(R.id.button_add_quote)
        val editTextAuthor : EditText = findViewById(R.id.editText_author)
        val editText : EditText = findViewById(R.id.editText_quote)
        button.setOnClickListener {
            val quote = Quote(editText.text.toString(), editTextAuthor.text.toString())
            viewModel.addQuote(quote)
            editText.setText("")
            editTextAuthor.setText("")
        }
    }
}