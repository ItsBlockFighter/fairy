/*
 * MIT License
 *
 * Copyright (c) 2021 Imanity
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.fairy.bukkit.reflection.version.protocol;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.fairy.bukkit.impl.annotation.ProviderTestImpl;
import org.fairy.bukkit.impl.test.ImplementationTest;
import org.fairy.bukkit.reflection.annotation.ProtocolImpl;
import protocolsupport.api.ProtocolSupportAPI;

@ProtocolImpl
@ProviderTestImpl(ProtocolCheckProtocolSupport.TestImpl.class)
public class ProtocolCheckProtocolSupport implements ProtocolCheck {
    @Override
    public int getVersion(Player player) {
        return ProtocolSupportAPI.getProtocolVersion(player).getId();
    }

    public static class TestImpl implements ImplementationTest {

        @Override
        public boolean test() {
            return Bukkit.getPluginManager().getPlugin("ProtocolSupport") != null;
        }
    }
}