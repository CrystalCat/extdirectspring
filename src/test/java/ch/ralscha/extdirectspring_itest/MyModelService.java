/**
 * Copyright 2010-2012 Ralph Schaer <ralphschaer@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.ralscha.extdirectspring_itest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;

@Service
public class MyModelService extends BaseService<MyModel> {

	@Override
	@ExtDirectMethod(value = ExtDirectMethodType.FORM_POST, group = "itest_base_service")
	public ExtDirectFormPostResult method1(HttpServletRequest request, HttpServletResponse response, MyModel model,
			final BindingResult result) {
		return new ExtDirectFormPostResult(result);
	}

	@Override
	public ExtDirectFormPostResult method2(HttpServletRequest request, HttpServletResponse response, MyModel model,
			final BindingResult result) {
		return new ExtDirectFormPostResult(result);
	}
}