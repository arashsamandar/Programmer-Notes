## NOTE :

> Git pull is a combination of two commands, `Git fetch` followed by `Git merge`.

> so you must Notice that if you use `Git pull`, your code will be replaced By the repository codes which you have just pulled from ( of course after you set your remote )
>
> if you don't want this, you must use `Git fetch`

### how to change your username in `Git`

> to change your username use `git config`
>
> ```
> git config --global user.name "arash samandar"
> ```

### how to change user email in git

> it is always starts with `git config` , like bellow :
>
> ```
> git config --global user.email youuser@gmail.co
> ```

----------------

> if you wish to see the content inside the directory use :
>
> ```
> ls -a .git
> ```

### how to ChangeUpStream in Git

```tex
git push --set-upstream origin main
// or
git push --set-upstream origin master
```

### Create and Go To New Branch

```text
git checkout -b myBranch
```

### checking which branch you are in

```text
git branch
```

### if you want to commit now, you have to change --set-upstream

```text
git remote --set-upstream myBranch
```

