>`git reset --hard HEAD`
>
>`git log --grep='yourSearchWord`'
>
>`git revert theLogHash`
>
>after doing this , __obviously__ the new files and folders would be `Untracked` and you can see them with `git status` .
>
>so if you wanna delete them now you should use :
>
>``git clean -fd` => and those files and folders would be removed now

### Using `git reset commitLog`

> for hard reset use `git reset` , __Warning__ this would change the `branching` .
>
> the `git revert` simply goes back and creates a new commit .
>
> but `git reset` would change the branch and commits
>
> `git reset` forgets any new commits __!!__

```
git reset --hard oldCommitHash

// and then to push it to remote branch too , use + plus like :

git push origin +main
```

## Best use `git revert`

