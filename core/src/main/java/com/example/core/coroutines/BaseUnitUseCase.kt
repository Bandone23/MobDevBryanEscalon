package com.example.core.coroutines

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext

abstract class BaseUnitUseCase<W : MutableLiveData<*>>(
    protected open val backgroundContext: CoroutineContext,
    protected open val foregroundContext: CoroutineContext
) {
    private var parentJob = Job()

    abstract fun execute(liveData: W)

    protected fun newJob(): Job {
        parentJob = parentJob.run {
            cancelChildren()
            cancel()

            Job()
        }

        return parentJob
    }
}
