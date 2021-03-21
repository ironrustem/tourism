<html lang="en">
<#include "base.ftl">
<#macro content1></#macro>

<#macro title>Улетающим</#macro>
<#macro content>

    <script src="js/chat.js"></script>



    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="https://use.fontawesome.com/45e03a14ce.js"></script>


    <br>
    <br>
    <br>
    <div class="main_section" id="chat2">
        <div class="container" id="chat1">

            <div class="col-sm-12 message_section">
                <div class="row">
                    <div class="new_message_head">
                        <div class="pull-left">
                            Ваш чат с поддержкой
                        </div>
                    </div>


                    <div class="chat_area" id="chat">
                        <ul class="list-unstyled" id="messages">


                        </ul>
                    </div>


                    <div class="message_write">
                        <textarea id = "textera" class="form-control" placeholder="type a message"></textarea>
                        <div class="clearfix"></div>

                        <p><input type="file" name="f" id="uploadimage">
                            <button class="pull-right btn btn-success" onclick="sendMes()">
                                Send</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
    <br>
    <br>
    <br>

</#macro>
</html>