package com.tlenparty.translator.rx

import io.reactivex.Scheduler

interface ISchedulerProvider {

    val ui:Scheduler

    val io:Scheduler
}