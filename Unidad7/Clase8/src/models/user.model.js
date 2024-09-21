export class User{
    constructor(name, email, password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    getName(){
        return this.name;
    }

    getEmail(){
        return this.email;
    }

    getPassword(){
        return this.password;
    }

    setName(name){
        this.name = name;
    }

    setEmail(email){
        this.email = email;
    }

    setPassword(password){
        this.password = password;
    }
}