/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.beniezsche.bikiboard.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.beniezsche.bikiboard.R;

/**
 * Displays the IME preferences inside the input method setting.
 */
public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        // We overwrite the title of the activity, as the default one is "Voice Search".
        setTitle(R.string.settings_name);

        Button addTextButton = findViewById(R.id.fillText);
        final EditText editText = findViewById(R.id.editText);

        addTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("Fusce gravida scelerisque nibh ut ullamcorper. Aliquam sed vestibulum ex, in vestibulum orci. Maecenas diam massa, dictum ac nulla at, viverra commodo erat. Donec sed urna lectus. Sed aliquam erat ut massa posuere, sed facilisis odio auctor. Proin id turpis at ipsum scelerisque convallis eget consectetur purus. Maecenas neque sem, dapibus luctus aliquam ut, vestibulum nec est. Curabitur tincidunt accumsan nulla sed commodo. Vivamus egestas sem justo, in porta arcu ullamcorper et. Morbi ante mi, tristique sit amet mi tincidunt, venenatis gravida ex. Nam eget nunc mattis, aliquam tortor non, ultricies mi. Donec vitae vulputate ante. Proin lacinia ac ligula non feugiat. \n" +
                        "\n" +
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus nulla purus, mattis a lacinia a, tincidunt id nulla. Pellentesque efficitur ipsum sed tellus sagittis porta. Sed vehicula ex ac lacus accumsan, in pretium enim egestas. Fusce vitae sollicitudin sem. Vivamus non nisi viverra mi accumsan placerat non a justo. Donec eget dolor neque. In pretium egestas ex non aliquam. Donec eu mauris sagittis, tincidunt est at, viverra lacus. Phasellus vel enim pulvinar, aliquet mauris sed, luctus nisl. Integer non urna ac quam pharetra consectetur. Cras nec mollis lacus, in tempor velit. Nullam nisi nunc, vulputate a tempus at, finibus non nisl. Nullam orci elit, rutrum eget velit in, placerat pretium velit. Duis mattis vulputate erat malesuada condimentum. Pellentesque mi orci, fringilla at dictum tincidunt, varius non dui.\n" +
                        "\n" +
                        "Pellentesque congue enim nec ante semper pulvinar. Nullam eget lorem tincidunt arcu tempor rutrum. Aliquam vitae suscipit elit. Duis lobortis euismod tellus ut iaculis. Donec ullamcorper eleifend consequat. Quisque placerat euismod mi, quis molestie lorem. Praesent et volutpat nibh. Integer laoreet aliquet suscipit. ");
            }
        });
    }
}
