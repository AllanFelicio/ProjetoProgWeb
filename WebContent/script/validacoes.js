




function validar(dom,tipo){
	switch(tipo){
		case'num':var regex=/[A-Za-z]/g;break;
		case'text':var regex=/\d/g;break;
	}
	dom.value=dom.value.replace(regex,'');
}

function mascara(t, mask){
 var i = t.value.length;
 var saida = mask.substring(1,0);
 var texto = mask.substring(i)
 if (texto.substring(0,1) != saida){
 t.value += texto.substring(0,1);
 }
 }
 
function numero(campo){  
var digits="0123456789-"  
var campo_temp   
    for (var i=0;i<campo.value.length;i++){  
        campo_temp=campo.value.substring(i,i+1)   
        if (digits.indexOf(campo_temp)==-1){  
            campo.value = campo.value.substring(0,i);  
        }  
    }  
}

function confirmaSenha(){
	
	senha1 = document.cad_user.senha.value;
	senha2 = document.cad_user.senha1.value;
	
	if(senha1 != senha2){
		
		alert("senha diferentes");
		document.cad_user.senha2.focus();
		return false;
		
	}
	
}

