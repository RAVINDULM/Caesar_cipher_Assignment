object Caesar_cipher_Assignment extends App{
  val Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

  val Encrypt =(c:Char,key:Int,alphabet:String)=>if(alphabet.contains(c)) alphabet((alphabet.indexOf(c)+key)%alphabet.length) else c
//  val Decrypt = (c:Char,key:Int,alphabet:String)=>if(alphabet.contains(c)) alphabet((alphabet.indexOf(c)-key)%alphabet.length) else c
  val Decrypt = (c:Char,key:Int,alphabet:String)=>if(alphabet.contains(c)) alphabet(if(alphabet.indexOf(c)<key) alphabet.length-key+alphabet.indexOf(c) else alphabet.indexOf(c)-key ) else c
  val Cipher = (algo:(Char,Int,String)=>Char,s:String,key:Int,alphabet:String)=>s.map(algo(_,key,alphabet))

  val plaintext = scala.io.StdIn.readLine("Secret Message: ")
  val Shift = (scala.io.StdIn.readLine("Shift By: ").toInt)

  val D =Cipher(Encrypt,plaintext,Shift,Alphabet)

  println(D)
  println(Cipher(Decrypt,D,Shift,Alphabet))
}