package agz.technologies.mvvmbasics.utilities

import agz.technologies.mvvmbasics.data.FakeDatabase
import agz.technologies.mvvmbasics.data.QuoteRepository
import agz.technologies.mvvmbasics.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory() : QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}