// Copyright (c) 2021 Terminus, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package cloud.erda.analyzer.runtime.expression.functions.aggregators;

/**
 * @author: liuhaoyang
 * @create: 2019-06-30 23:09
 **/
public class CountFunctionAggregator implements FunctionAggregator {

    private long count = 0;

    @Override
    public String aggregator() {
        return FunctionAggregatorDefine.COUNT;
    }

    @Override
    public Object value() {
        return count;
    }

    @Override
    public void apply(Object value) {
        if (value != null) {
            count++;
        }
    }

    @Override
    public void merge(FunctionAggregator other) {
        if (other instanceof CountFunctionAggregator) {
            count += ((CountFunctionAggregator) other).count;
        }
    }
}