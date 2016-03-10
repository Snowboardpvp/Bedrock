/**
 * This file is part of Bedrock, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2016 Helion3 http://helion3.com/
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.helion3.bedrock.data.invincibility;

import com.helion3.bedrock.util.BedrockKeys;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataHolder;
import org.spongepowered.api.data.manipulator.mutable.common.AbstractBooleanData;
import org.spongepowered.api.data.merge.MergeFunction;
import org.spongepowered.api.data.value.mutable.Value;

import java.util.Optional;

public class InvincibilityData extends AbstractBooleanData<InvincibilityData, ImmutableInvincibilityData> {
    public InvincibilityData() {
        this(false);
    }

    public InvincibilityData(boolean invincible) {
        super(invincible, BedrockKeys.IS_INVINCIBLE, false);
    }

    public Value<Boolean> invincible() {
        return getValueGetter();
    }

    @Override
    public ImmutableInvincibilityData asImmutable() {
        return new ImmutableInvincibilityData(getValueGetter().get());
    }

    @Override
    public Optional<InvincibilityData> fill(DataHolder dataHolder, MergeFunction overlap) {
        return null;
    }

    @Override
    public Optional<InvincibilityData> from(DataContainer container) {
        if (container.contains(BedrockKeys.IS_INVINCIBLE.getQuery())) {
            return Optional.of(new InvincibilityData(container.getBoolean(BedrockKeys.IS_INVINCIBLE.getQuery()).get()));
        }

        return Optional.empty();
    }

    @Override
    public InvincibilityData copy() {
        return new InvincibilityData(getValueGetter().get());
    }

    @Override
    public int getContentVersion() {
        return 1;
    }
}
