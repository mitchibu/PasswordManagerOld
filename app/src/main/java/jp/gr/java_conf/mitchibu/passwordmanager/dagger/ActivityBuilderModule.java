package jp.gr.java_conf.mitchibu.passwordmanager.dagger;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jp.gr.java_conf.mitchibu.passwordmanager.MainActivity;
import jp.gr.java_conf.mitchibu.passwordmanager.OutlineFragment;

@Module
abstract class ActivityBuilderModule {
	@ContributesAndroidInjector
	abstract MainActivity contributeMainActivity();
	@ContributesAndroidInjector
	abstract OutlineFragment contributeOutlineFragment();
}
