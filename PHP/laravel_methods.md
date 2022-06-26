#### return back()->with('message' => 'hello arash')

```
return back()->with('message' => 'hello arash');
```

### Sending Email

```markdown
Mail::send('email.forgetPassword', ['token' => $token], function($message) use($request){
            $message->to($request->input('email'));
            $message->subject('Reset Password');
        });
```

