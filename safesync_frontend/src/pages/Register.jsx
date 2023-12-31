import React, { useState } from "react";
import axios from "axios";
import { useNavigate, Link } from "react-router-dom";

const Register = () => {
  const [err, setErr] = useState(false);
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    setLoading(true);
    e.preventDefault();
    const role = e.target[0].value;
    const email = e.target[1].value;
    const password = e.target[2].value;

    // try {
    //   //Create user
    //   const res = await createUserWithEmailAndPassword(auth, email, password);

    //   //Create a unique image name
    //   const date = new Date().getTime();
    //   const storageRef = ref(storage, `${displayName + date}`);

    //   await uploadBytesResumable(storageRef, file).then(() => {
    //     getDownloadURL(storageRef).then(async (downloadURL) => {
    //       try {
    //         //Update profile
    //         await updateProfile(res.user, {
    //           displayName,
    //           photoURL: downloadURL,
    //         });
    //         //create user on firestore
    //         await setDoc(doc(db, "users", res.user.uid), {
    //           uid: res.user.uid,
    //           displayName,
    //           email,
    //           photoURL: downloadURL,
    //         });

    //         //create empty user chats on firestore
    //         await setDoc(doc(db, "userChats", res.user.uid), {});
    //         navigate("/");
    //       } catch (err) {
    //         console.log(err);
    //         setErr(true);
    //         setLoading(false);
    //       }
    //     });
    //   });
    // }
    // catch (err) {
    //   setErr(true);
    //   setLoading(false);
    // }

    axios
      .post("https://api.example.com/endpoint", {
        role: role,
        email: email,
        password: password,
      })
      .then((response) => {
        // Handle success
        console.log(response.data);
      })
      .catch((error) => {
        // Handle error
        console.error(error);
      });
  };

  return (
    <div className="formContainer">
      <div className="formWrapper">
        <span className="logo">Lama Chat</span>
        <span className="title">Register</span>
        <form onSubmit={handleSubmit}>
          <input required type="text" placeholder="role" />
          <input required type="email" placeholder="email" />
          <input required type="password" placeholder="password" />

          <button disabled={loading}>Sign up</button>
          {err && <span>Something went wrong</span>}
        </form>
        <p>
          You do have an account? <Link to="/register">Login</Link>
        </p>
      </div>
    </div>
  );
};

export default Register;
