def print_string_permutation(s_array,i):
	s_len = len(s_array)

	if i == s_len -1:
		print s_array

	else:	
		j = i

		while j < len(s_array):
			s_array[i],s_array[j] = s_array[j],s_array[i]
			print_string_permutation(s_array,i+1)
			s_array[i],s_array[j] = s_array[j],s_array[i]
			j = j+1;


def main():
	a = ['A','B','C','D','E','F']
	print_string_permutation(a,0)

main()
