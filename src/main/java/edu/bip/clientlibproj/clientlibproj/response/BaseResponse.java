package edu.bip.clientlibproj.clientlibproj.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseResponse {

    // Класс, в котором можно будет понять, дошёл ли твой маленький запрос до дома Базы Данных
    // Или его слопала Волк-Ошибка или ещё какая-нибудь цифровая фигня)

    protected  boolean success; // логическое поле, которое будет говорить что запрос прошел (true) или нет (falsh);
    protected  String message; //сообщение которое содержит информацию о том что произошло (к примеру, если все плохо, сообщение об ошибке).
}
