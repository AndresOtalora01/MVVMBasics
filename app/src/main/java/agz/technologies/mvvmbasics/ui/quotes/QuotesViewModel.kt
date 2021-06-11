package agz.technologies.mvvmbasics.ui.quotes

import agz.technologies.mvvmbasics.data.Quote
import agz.technologies.mvvmbasics.data.QuoteRepository
import androidx.lifecycle.ViewModel

class QuotesViewModel (private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}