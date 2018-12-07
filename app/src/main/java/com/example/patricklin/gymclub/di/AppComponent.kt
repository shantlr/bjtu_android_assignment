package com.example.patricklin.gymclub.di

import com.example.patricklin.gymclub.GymClubApp
import com.example.patricklin.gymclub.feature.auth.LoginActivity
import com.example.patricklin.gymclub.feature.auth.RegisterActivity
import com.example.patricklin.gymclub.StartActivity
import com.example.patricklin.gymclub.feature.session.SessionDetailsActivity
import com.example.patricklin.gymclub.feature.session.SessionsFragment
import com.example.patricklin.gymclub.feature.home.HomeActivity
import com.example.patricklin.gymclub.feature.news.NewsDetailsActivity
import com.example.patricklin.gymclub.feature.news.NewsFragment
import com.example.patricklin.gymclub.feature.trainer.TrainerDetailActivity
import com.example.patricklin.gymclub.feature.video.VideoActivity
import com.example.patricklin.gymclub.feature.video.VideoListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AuthModule::class,
    NewsModule::class,
    ClassModule::class,
    TrainerModule::class,
    VideoModule::class,
    BackApiModule::class,
    DbModule::class
])
interface AppComponent {
    fun inject(app: GymClubApp)

    fun inject(activity: StartActivity)

    fun inject(activity: LoginActivity)
    fun inject(activity: RegisterActivity)

    fun inject(activity: HomeActivity)

    fun inject(fragment: NewsFragment)
    fun inject(activity: NewsDetailsActivity)

    fun inject(fragment: SessionsFragment)
    fun inject(activity: SessionDetailsActivity)

    fun inject(fragment: VideoListFragment)
    fun inject(activity: VideoActivity)

    fun inject(activity: TrainerDetailActivity)
}
