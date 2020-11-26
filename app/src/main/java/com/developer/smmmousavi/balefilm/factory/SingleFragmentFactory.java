package com.developer.smmmousavi.balefilm.factory;

import com.developer.smmmousavi.balefilm.ui.fragments.base.BaseDaggerFragment;

public interface SingleFragmentFactory {

   /*
    * Factory Method Design Pattern
    * Functionality: Factory methods which return products
    */

   BaseDaggerFragment createFragment();

   String getTag();
}
