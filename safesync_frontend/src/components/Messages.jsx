import { doc, onSnapshot } from "firebase/firestore";
import React, { useContext, useEffect, useState } from "react";
import { ChatContext } from "../context/ChatContext";
import Message from "./Message";

const Messages = () => {
  const {allMessages, allresponseMeesages} = useContext(ChatContext);
  // const { data } = useContext(ChatContext);

  // useEffect(() => {
  //   const unSub = onSnapshot(doc(db, "chats", data.chatId), (doc) => {
  //     doc.exists() && setMessages(doc.data().messages);
  //   });

  //   return () => {
  //     unSub();
  //   };
  // }, [data.chatId]);

  // console.log(messages)

  return (
    // <div className="messages">
    //   {messages.map((m) => (
    //     <Message message={m} key={m.id} />
    //   ))}
    // </div>

    <div className="messages">
      {allMessages&& allMessages.map((m)=>{
        return <Message key={m.id} message={m.message} sender = {m.sender}/>
      })}
    </div>

  );
};

export default Messages;
