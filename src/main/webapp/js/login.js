let newuserid = null;
//the submit event
async function loginSubmit(e){
    e.preventDefault();

    let username = document.getElementById("username-input").value
    let password = document.getElementById("password-input").value

    //enhanced object literals
    const credentials = {
        username,//this is the same as below
        password:password
    }

    try{

        let res = await fetch("http://localhost:8080/ProjectOne/login.page",{
            method:"POST",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })
        let user = await res.json()
        if(user){
            if(user.user_role_id == 1){
               localStorage.setItem("newuserid",user.ers_users_id);
            window.location.href="/ProjectOne/employee.page";
        }
             else if(user.user_role_id == 2){
          window.location.href="/ProjectOne/financemanager.page";
      }else{
        console.log("Invalid Username or Password")
    }
}
         else{
          console.log("Invalid Username or Password")
    }
        console.log(user);
    } catch( e) {
        console.log(e);
    }
}


document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit)